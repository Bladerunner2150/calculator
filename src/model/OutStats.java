/**
 * 
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import util.Score;

/**
 * @author Bart Taelemans & Thomas Vanden Bossche
 * @date 9 okt. 2017
 * @project Calculator
 * @purpose Generate exercise statistics
 *
 */
public class OutStats {
	private Date dateOfTest;
	private long duration;
	private String selections;
	private String finalResult;
	private String separator = System.lineSeparator();

	/**
	 * @return the dateOfTest
	 */
	public Date getDateOfTest() {
		return dateOfTest;
	}

	/**
	 * @param dateOfTest
	 *            the dateOfTest to set
	 */
	public void setDateOfTest(Date dateOfTest) {
		this.dateOfTest = dateOfTest;
	}

	/**
	 * @return the duration
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(long duration) {
		this.duration = duration;
	}

	/**
	 * @return the selections
	 */
	public String getSelections() {
		return selections;
	}

	/**
	 * @param selections
	 *            the selections to set
	 */
	public void setSelections(String selections) {
		this.selections = selections;
	}

	/**
	 * @return the finalResult
	 */
	public String getFinalResult() {
		return finalResult;
	}

	/**
	 * @param finalResult
	 *            the finalResult to set
	 */
	public void setFinalResult(String finalResult) {
		this.finalResult = finalResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stats:" + separator + separator + "Date and time of test: " + getDateOfTest() + separator
				+ "Duration of test: " + getDuration() + " seconds" + separator + "Selected properties: " + separator
				+ getSelections() + separator + "Final result: " + getFinalResult();
	}

	public void ListOut(File f, ArrayList<Score> e) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(f);
		@SuppressWarnings({ "unused", "resource" })
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(e);
	}

	public ArrayList<Score> LijstInlezen(File file) throws ClassNotFoundException, IOException {
		FileInputStream fileInputStream = new FileInputStream(file);
		@SuppressWarnings("resource")
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		@SuppressWarnings("unchecked")
		ArrayList<Score> f = (ArrayList<Score>) objectInputStream.readObject();
		return f;

	}

}
