package org.qa.userproducerapp;

import com.google.gson.Gson;
import org.qa.userproducerapp.constants.Constants;
import org.qa.userproducerapp.dal.QuestionsRepository;
import org.qa.userproducerapp.model.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
public class QuestionsController {

    @Autowired
    private QuestionsRepository repo;
    @Autowired
    private Gson gson;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RestTemplate restTemplate;


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/questions/getAll")
    private List<Level> getAllQuestions(){

        //String questions = restTemplate.getForObject(Constants.QUESTIONS_API_ALL, String.class);
        log.info("getting all users. total {}", repo.count());
        List<Level> levels = new ArrayList<>();
        repo.findAll().forEach(levels::add);

        return levels;
    }




}
