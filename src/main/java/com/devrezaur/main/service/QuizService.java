package com.devrezaur.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devrezaur.main.model.Question;
import com.devrezaur.main.model.QuestionForm;
import com.devrezaur.main.model.Result;
import com.devrezaur.main.repository.QuestionRepo;
import com.devrezaur.main.repository.ResultRepo;


@Service
public class QuizService {
	
	@Autowired
	Question question;
	@Autowired
	QuestionForm qForm;
	@Autowired
	Result result;
	@Autowired
	QuestionRepo qRepo;
	@Autowired
	ResultRepo rRepo;
	
	public QuestionForm getQuestion() {
		List<Question> allQ = qRepo.findAll();
		List<Question> fiveQ=new ArrayList<Question>();
		Random random=new Random();
		for(int i=0;i<5;i++) {
			int rand= random.nextInt(allQ.size());
			fiveQ.add(allQ.get(rand));
			allQ.remove(rand);
		}
		qForm.setQuestions(fiveQ);
		return qForm;
	}
	
	public int totalScore(QuestionForm qForm) {
		int total=0;
		for(Question q: qForm.getQuestions()) {
			if(q.getAns()==q.getChose()) total++;
		}
		return total;
	}
	
	public void saveResult(Result result) {
		Result r=new Result();
		r.setUsername(result.getUsername());
		r.setTotalCorrect(result.getTotalCorrect());
		rRepo.save(r);
	}
	public List<Result> getAllResult(){
		List<Result> rList= rRepo.findAll(Sort.by(Sort.Direction.DESC,"totalCorrect"));
		return rList;
	}
}
