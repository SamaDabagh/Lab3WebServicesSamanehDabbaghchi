package webCourseREST;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.*;

@Path("WebCourse")
public class WebCourseResource {

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayHTMLCourseInfo()
	{
		List<Course> courseRecords = new ArrayList<Course>(7);
		courseRecords.add(createCourseList("MIS_101","Intro.to.Info.Systems", 3	,140));
		courseRecords.add(createCourseList("MIS_301","Systems.Analysis", 3	,35));
		courseRecords.add(createCourseList("MIS_441","Database.Management", 3	,12));
		courseRecords.add(createCourseList("CS_155","Programming.in.C++", 3	,90));
		courseRecords.add(createCourseList("MIS_451","Web-Based.Systems", 3	,30));
		courseRecords.add(createCourseList("MIS_551","Advanced.Web", 3	,30));
		courseRecords.add(createCourseList("MIS_651","Advanced.Java", 3	,30));
		
		double TotalCourseFees = 0.00;
		
		String htmlTable = "<table border = 1 style=\"text-align: center; margin-top: 40px; margin-left: 25%;\"><tr>"
							+"<th style=\"padding: 10px;\"> Course No </th>"
							+ "<th style=\"padding: 10px;\">Course Name</th>"
							+ "<th style=\"padding: 10px;\">Max Enrlment</th>"
							+ "<th style=\"padding: 10px;\">Credits</th>"
							+ "<th style=\"padding: 10px;\">Total Course Fee</th></tr>";
		for(int i  = 0 ; i < courseRecords.size() ; i++) 
		{	htmlTable += 
					"<tr><td style=\"padding: 10px;\">" +courseRecords.get(i).getCourse_no()+ "</td>"
						+ "<td style=\"padding: 10px;\">" +courseRecords.get(i).getCourse_name()+"</td>"
						+ "<td style=\"padding: 10px;\">" +courseRecords.get(i).credit+"</td>"
						+ "<td style=\"padding: 10px;\">" +courseRecords.get(i).getMax_enrl()+"</td>"
						+ "<td style=\"padding: 10px;\">" +courseRecords.get(i).CalculateTotalFees()+" $</td></tr>";
		TotalCourseFees += courseRecords.get(i).CalculateTotalFees();
		
		};
		htmlTable += "</table></br><h2 style=\"text-align: center; margin-top: 20px; \">The Total of Course Fee is: "+TotalCourseFees+" $</h2>";
				
		return htmlTable;
		
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String displayTextBillingInfo()
	{
		List<Course> courseRecords = new ArrayList<Course>(7);
		courseRecords.add(createCourseList("MIS_101","Intro.to.Info.Systems", 3	,140));
		courseRecords.add(createCourseList("MIS_301","Systems.Analysis", 3	,35));
		courseRecords.add(createCourseList("MIS_441","Database.Management", 3	,12));
		courseRecords.add(createCourseList("CS_155","Programming.in.C++", 3	,90));
		courseRecords.add(createCourseList("MIS_451","Web-Based.Systems", 3	,30));
		courseRecords.add(createCourseList("MIS_551","Advanced.Web", 3	,30));
		courseRecords.add(createCourseList("MIS_651","Advanced.Java", 3	,30));
		

		String plainStr = "";
		double TotalCourseFees = 0.00;
		for(Course courseRecord : courseRecords)
		{
			TotalCourseFees += courseRecord.CalculateTotalFees();
			plainStr +="\nComponent at index " +courseRecords.indexOf(courseRecord)+":"+courseRecord;

		}
		
		return plainStr +"\n\nThe Total of Course Fee is: "+TotalCourseFees+" $";
	}
	
	@GET
	@Path("/searchCourse/{course_no}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course searchJSONCourseInfo(@PathParam("course_no") String course_no)
	{
		List<Course> courseRecords = new ArrayList<Course>(7);
		courseRecords.add(createCourseList("MIS_101","Intro.to.Info.Systems", 3	,140));
		courseRecords.add(createCourseList("MIS_301","Systems.Analysis", 3	,35));
		courseRecords.add(createCourseList("MIS_441","Database.Management", 3	,12));
		courseRecords.add(createCourseList("CS_155","Programming.in.C++", 3	,90));
		courseRecords.add(createCourseList("MIS_451","Web-Based.Systems", 3	,30));
		courseRecords.add(createCourseList("MIS_551","Advanced.Web", 3	,30));
		courseRecords.add(createCourseList("MIS_651","Advanced.Java", 3	,30));
		
		for(Course courseRecord: courseRecords)
		{
			if (courseRecord.getCourse_no().equals(course_no))
				return courseRecord;
		}
		
		return null;
	}
	
	
	public Course createCourseList(String course_no, String course_name, int credit,int max_enrl)

	{
			Course myCourse = new Course();
			myCourse.setCourse_no(course_no);
			myCourse.setCourse_name(course_name);
            myCourse.credit = credit;
            myCourse.setMax_enrl(max_enrl);

		return myCourse;
	
	}
	
}
