package model;

import java.util.ArrayList;

public class Result {
	public long DBTime;
	public long DWTime;
	public int Count;
	public ArrayList<String[]> MovieId;
	
	public Result(long ResDBTime, long ResDWTime,int ResCount, ArrayList<String[]> ResMovieId) {		
		MovieId = new ArrayList<String[]>(ResMovieId);	
		DBTime = ResDBTime;
		DWTime = ResDWTime;
		Count = ResCount;
	}

	public Result(Result res) {
		this(res.DBTime, res.DWTime, res.Count, res.MovieId);
	}
}
