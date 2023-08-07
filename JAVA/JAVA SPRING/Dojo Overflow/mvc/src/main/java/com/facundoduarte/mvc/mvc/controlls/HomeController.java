package com.facundoduarte.mvc.mvc.controlls;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.facundoduarte.mvc.mvc.models.Answer;
import com.facundoduarte.mvc.mvc.models.Question;
import com.facundoduarte.mvc.mvc.models.QuestionTag;
import com.facundoduarte.mvc.mvc.models.Tag;
import com.facundoduarte.mvc.mvc.services.AnswerService;
import com.facundoduarte.mvc.mvc.services.QuestionService;
import com.facundoduarte.mvc.mvc.services.TagService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    private QuestionService questionService;
    private TagService tagService;
    private final AnswerService answerService;

    public HomeController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;

    }

    @GetMapping(value = "/")
    public String redirectIndex() {
        return "redirect:/questions";
    }

    @GetMapping(value = "/questions")
    public String index(Model model) {

        List<Question> questions = questionService.allQuestions();
        model.addAttribute("questions", questions);
        return "index";
    }

    @GetMapping(value = "/questions/new")
    public String newQuestion(Model model) {
        model.addAttribute("questionTag", new QuestionTag());
        return "question";
    }

    @PostMapping(value = "/questions/new")
    public String createQuestion(@ModelAttribute("questionTag") QuestionTag questionTag, BindingResult result,
            RedirectAttributes redirectAttributes) {
        Tag tag = questionTag.getTag();
        Question question = questionTag.getQuestion();
        Tag existingTag = tagService.getTagBySubject(tag.getSubject());

        String[] arrayTags = tag.getSubject().split(",");
        if (arrayTags.length > 3) {
            result.rejectValue("tag.subject", "Maximo 3 etiquetas por pregunta");
            redirectAttributes.addFlashAttribute("error", "Maximo 3 etiquetas por pregunta");
            return "redirect:/questions/new";
        }
        if (result.hasErrors()) {
            return "question";
        } else {
            if (existingTag != null) {
                tag = existingTag;
            } else {
                tagService.createTag(tag);
            }
            question.getTags().add(tag);
            questionService.createQuestion(question);
        }
        return "redirect:/questions/new";
    }

    @GetMapping(value = "/questions/{id}")
    public String showQuestion(@PathVariable Long id, Model model) {
        Question question = questionService.findQuestion(id);
        List<Tag> tags = question.getTags();
        List<Answer> answers = question.getAnswers();
        model.addAttribute("answers", answers);
        model.addAttribute("question", question);
        model.addAttribute("tags", tags);
        return "forum";
    }

    @PostMapping(value = "/questions/{questionId}")
    public String createAnswer(@PathVariable Long questionId,
            @RequestParam("answerText") String answerText,
            @Valid @ModelAttribute("answer") Answer answer,
            BindingResult result) {
        if (result.hasErrors()) {
            return "forum";
        } else {
            Question question = questionService.findQuestion(questionId);

            Answer newAnswer = new Answer();
            newAnswer.setQuestionAnswer(answerText);
            newAnswer.setQuestion(question);

            answerService.createAnswer(newAnswer);
            return "redirect:/questions/" + questionId;
        }
    }
}
