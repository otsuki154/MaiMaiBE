package com.maimai.Master.Grammar;

import java.util.ArrayList;
import java.util.List;


public class GrammarReqModel {
	
	Long grammarNo;
	String grammarCd;
	String grammarContent;
	String meanVi;
	String meanFunction;
	String wayUse;
	String literaryNature;
	String example;
	String diffLevel;
	
	
	/**
	 * @return the grammarNo
	 */
	public Long getGrammarNo() {
		return grammarNo;
	}
	/**
	 * @param grammarNo the grammarNo to set
	 */
	public void setGrammarNo(Long grammarNo) {
		this.grammarNo = grammarNo;
	}
	/**
	 * @return the grammarCd
	 */
	public String getGrammarCd() {
		return grammarCd;
	}
	/**
	 * @param grammarCd the grammarCd to set
	 */
	public void setGrammarCd(String grammarCd) {
		this.grammarCd = grammarCd;
	}
	/**
	 * @return the grammarContent
	 */
	public String getGrammarContent() {
		return grammarContent;
	}
	/**
	 * @param grammarContent the grammarContent to set
	 */
	public void setGrammarContent(String grammarCcontent) {
		this.grammarContent = grammarCcontent;
	}
	/**
	 * @return the meanVi
	 */
	public String getMeanVi() {
		return meanVi;
	}
	/**
	 * @param meanVi the meanVi to set
	 */
	public void setMeanVi(String meanVi) {
		this.meanVi = meanVi;
	}
	/**
	 * @return the meanFunction
	 */
	public String getMeanFunction() {
		return meanFunction;
	}
	/**
	 * @param meanFunction the meanFunction to set
	 */
	public void setMeanFunction(String meanFfunction) {
		this.meanFunction = meanFfunction;
	}
	/**
	 * @return the wayUse
	 */
	public String getWayUse() {
		return wayUse;
	}
	/**
	 * @param wayUse the wayUse to set
	 */
	public void setWayUse(String wayUse) {
		this.wayUse = wayUse;
	}
	/**
	 * @return the literaryNature
	 */
	public String getLiteraryNature() {
		return literaryNature;
	}
	/**
	 * @param literaryNature the literaryNature to set
	 */
	public void setLiteraryNature(String literaryNature) {
		this.literaryNature = literaryNature;
	}
	/**
	 * @return the example
	 */
	public String getExample() {
		return example;
	}
	/**
	 * @param example the example to set
	 */
	public void setExample(String example) {
		this.example = example;
	}
	/**
	 * @return the diffLevel
	 */
	public String getDiffLevel() {
		return diffLevel;
	}
	/**
	 * @param diffLevel the diffLevel to set
	 */
	public void setDiffLevel(String diffLevel) {
		this.diffLevel = diffLevel;
	}
	
	  
		public static List<GrammarReqModel> getListGrammar (List<String> listStr)
		{
			List<GrammarReqModel> listGrammar = new ArrayList<GrammarReqModel>();
			for (String str : listStr) {
				GrammarReqModel user = new GrammarReqModel();
				String[] item = str.split(",");
				user.setGrammarCd(item[0]);
				user.setGrammarContent(item[1]);
				user.setMeanVi(item[2]);
				user.setMeanFunction(item[3]);
				user.setWayUse(item[4]);
				user.setLiteraryNature(item[5]);
				user.setExample(item[6]);
				user.setDiffLevel(item[7]);
				listGrammar.add(user);
			}
			return listGrammar;
		}

}
