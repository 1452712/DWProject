package model;

import java.util.ArrayList;

public class Result {
	public long DBTime;
	public long DWTime;
	public int Count;
	public ArrayList<String> MovieId;
	
	public Result(long ResDBTime, long ResDWTime,int ResCount, ArrayList<String> ResMovieId) {	
		this.MovieId = new ArrayList<String>(ResMovieId);	
		this.DBTime = ResDBTime;
		this.DWTime = ResDWTime;
		this.Count = ResCount;
	}

	public Result(Result res) {
		this(res.DBTime, res.DWTime, res.Count, res.MovieId);
	}
}
