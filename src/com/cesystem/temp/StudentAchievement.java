package com.cesystem.temp;

import java.util.List;

import com.cesystem.pojo.ChooseClass;
import com.cesystem.pojo.PeerEvaluation;
import com.cesystem.pojo.Student;
import com.cesystem.pojo.WinScore;

public class StudentAchievement {
	
	private Student student;
	private List<ChooseClass> chooseClasses;
	private List<PeerEvaluation> peerEvaluations;
	private List<WinScore> winScores;
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<ChooseClass> getChooseClasses() {
		return chooseClasses;
	}
	public void setChooseClasses(List<ChooseClass> chooseClasses) {
		this.chooseClasses = chooseClasses;
	}
	public List<PeerEvaluation> getPeerEvaluations() {
		return peerEvaluations;
	}
	public void setPeerEvaluations(List<PeerEvaluation> peerEvaluations) {
		this.peerEvaluations = peerEvaluations;
	}
	public List<WinScore> getWinScores() {
		return winScores;
	}
	public void setWinScores(List<WinScore> winScores) {
		this.winScores = winScores;
	}

}
