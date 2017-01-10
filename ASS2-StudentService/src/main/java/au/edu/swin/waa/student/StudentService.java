package au.edu.swin.waa.student;


public class StudentService
{
	/*public static void main(String ar[])
	{
		StudentService s = new StudentService();
		System.out.println(s.authenticateStudent("1234", "0123"));
	}*/
	
	public String authenticateStudent(String enteredId, String enteredPin)
	{
		try
			{

			

			StudentDBInterface db = new StudentDBInterface();
			String student = db.getStudentFromDB(enteredId);
			if(student!=null)
			{
				String[] stuDet = splitData(student);
				if(enteredPin.equals(stuDet[2]))
				{
					return "Authenticated";
					
				}
				
				return "Failed";
			}

			return "Failed";

			}
			catch(Exception ex)
			{
				return "Failed";
			}
	}
	private static String[] splitData(String data)
    {
    	String[] parts = data.split("\\~");
    	return parts;
    }
}