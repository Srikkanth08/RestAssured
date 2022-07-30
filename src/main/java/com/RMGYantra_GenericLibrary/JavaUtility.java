package com.RMGYantra_GenericLibrary;

import java.util.Random;

public class JavaUtility 
{
	public int generateRandom()
	{
		Random R = new Random(1000);
		int random = R.nextInt();
		return random;
	}
}
