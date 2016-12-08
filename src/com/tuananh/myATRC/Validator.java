package com.tuananh.myATRC;

import com.microsoft.z3.*;
import java.util.*;

public class Validator
{
	@SuppressWarnings("serial")
	class TestFailedException extends Exception
	{
		public TestFailedException()
		{
			super("Check FAILED");
		}
	};

	public boolean checkInvarants(String Ini, String Evo)
	{
		String tmp1 = Data.getInstance().iniInvarant.standardizedText(Ini);
		String tmp2 = Data.getInstance().iniInvarant.standardizedText(Evo);
		Scanner scanner1 = new Scanner(tmp1);
		/*
		 * check the number of invarants in two string is equal or not
		 */
		String[] numLines1 = tmp1.split("\n");
		String[] numLines2 = tmp2.split("\n");
		if (numLines1.length != numLines2.length)
		{
			scanner1.close();
			return false;
		} else
		{
			System.out.println("numbers of lines is equal");
		}
		while (scanner1.hasNextLine())
		{
			String tmpLine = scanner1.nextLine();
			if (!tmp2.contains(tmpLine))
			{
				scanner1.close();
				return false;
			}
		}
		scanner1.close();
		return true;
	}
	
	public boolean checkPrecondition(Context ctx, Expr initial, Expr evolution) throws Z3Exception
	{
		Solver solver = Data.getInstance().ctx.mkSolver();
		BoolExpr pre1 = Data.getInstance().ctx.mkImplies((BoolExpr)initial, (BoolExpr)evolution);
		BoolExpr pre2 = Data.getInstance().ctx.mkImplies( (BoolExpr)evolution,(BoolExpr)initial);
		solver.add(pre1);
		solver.add(pre2);
		Status st = solver.check();
		if(st ==Status.SATISFIABLE) return true;
		else return false;
	}
	
	public int checkPostCondition(Context ctx, Expr initial, Expr evolution)
	{
		Solver solver = Data.getInstance().ctx.mkSolver();
	BoolExpr post1 = Data.getInstance().ctx.mkImplies((BoolExpr)initial, (BoolExpr)evolution);
	BoolExpr post2 = Data.getInstance().ctx.mkImplies( (BoolExpr)evolution,(BoolExpr)initial);
	solver.add(post1);
	Status st =solver.check();
	if(st == Status.SATISFIABLE)
	{
		solver.add(post2);
		Status st2 = solver.check();
		if(st2 == Status.SATISFIABLE) return 0;//2 postconditions are equivalent
		else return 1;//2 initial implies evolution
	}
	else return 2; //not satisfiy
	}
	public Result validateConditions(Context ctx, String iniInvarants, String evoInvarants, Expr iniPre, Expr iniPost, Expr evoPre, Expr evoPost)
	{
//		boolean pre;
//		int post;
		if(!checkInvarants(iniInvarants, evoInvarants)) return Result.UNCONSISTENCY;
		else
		{
			if(!checkPrecondition(ctx, iniPre, evoPost)) return Result.UNCONSISTENCY;
			else
			{
				if(checkPostCondition(ctx, iniPost, evoPost)==0) return Result.TOTAL_CONSISTENCY;
				else return Result.PARTIAL_CONSISTENCY;
			}
		}
	}
};
