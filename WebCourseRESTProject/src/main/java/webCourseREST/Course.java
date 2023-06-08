package webCourseREST;


import java.util.Objects;

public class Course {


		private String course_no;
		private String course_name;
		public static int credit;
		private int max_enrl;
		
		public Course() {
			
			course_no = "";
			course_name = "";
			max_enrl = 0;

		}

		public Course(String course_no, String course_name, int max_enrl) {
		
			this.course_no = course_no;
			this.course_name = course_name;
			this.max_enrl = max_enrl;
		}

		public String getCourse_no() {
			return course_no;
		}

		public void setCourse_no(String course_no) {
			this.course_no = course_no;
		}

		public String getCourse_name() {
			return course_name;
		}

		public void setCourse_name(String course_name) {
			this.course_name = course_name;
		}

		public int getMax_enrl() {
			return max_enrl;
		}

		public void setMax_enrl(int max_enrl) {
			this.max_enrl = max_enrl;
		}

		@Override
		public String toString() {
			return " " + course_no + "// " + course_name + "// " +  credit+"// "+ max_enrl + "";
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(course_name, course_no, max_enrl);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Course other = (Course) obj;
			return Objects.equals(course_name, other.course_name) && Objects.equals(course_no, other.course_no)
					&& max_enrl == other.max_enrl;
		}

		public double CalculateTotalFees()
		{
			return max_enrl*250.00;
		}
}
