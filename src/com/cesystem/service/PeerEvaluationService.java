package com.cesystem.service;

import java.util.List;

import com.cesystem.temp.PeerEvaluationTemp;

public interface PeerEvaluationService {

	public List<PeerEvaluationTemp> getPeerEvaluation(int studentId);

	public boolean addPeerEvaluation(String[] stringExc, String[] stringGood,
			String[] stringMod, String[] stringCom, int studentId);
	
	List<PeerEvaluationTemp> getPeerEvaluationByClassNumber(String classNumber);
}
