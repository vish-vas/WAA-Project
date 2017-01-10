package au.edu.swin.waa.evaluate;

public class EvaluateResponse
{
	public String evaluateGoogleResponse(String rating, String availability)
	{
		Double rate;
		try
		{
			rate = Double.parseDouble(rating);
		}
		catch(Exception e)
		{
			return "The book with given ISBN has no rating. So, it can not be added.";
		}
		if(rate<3)
		{
			return "The book with given ISBN has rating below 3. So, it can not be added.";
		}
		if(availability.equalsIgnoreCase(""))
		{
			return "The book with given ISBN does not have saleability information. So, it can not be added.";
		}
		if(!availability.equalsIgnoreCase("FOR_SALE"))
		{
			return "The book with given ISBN is not available for sale in Australia. So, it can not be added.";
		}
		return "true";
	}
}