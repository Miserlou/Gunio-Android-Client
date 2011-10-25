package io.gun.gunbot;

import java.util.List;

public class Careers {
	private int limit;
	private String next;
	private int offset;
	private String previous;
	private int total_count;
	
	private List<Career> objects;
	
	public class Career{
		private String about;
		private String about_mkd;
		private City city;
		private String company_name;
		private String cost;
		private String date_expired;
		private String homepage;
		private String id;
		private String job;
		private String job_mkd;
		private boolean posted;
		private boolean preview;
		private String resource_uri;
		private String salary;
		private String skills;
		private String skills_mkd;
		private String slug;
		private String title;
		private String user;
		public String getAbout() {
			return about;
		}
		public void setAbout(String about) {
			this.about = about;
		}
		public String getAbout_mkd() {
			return about_mkd;
		}
		public void setAbout_mkd(String about_mkd) {
			this.about_mkd = about_mkd;
		}
		public String getCompany_name() {
			return company_name;
		}
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}
		public String getCost() {
			return cost;
		}
		public void setCost(String cost) {
			this.cost = cost;
		}
		public String getDate_expired() {
			return date_expired;
		}
		public void setDate_expired(String date_expired) {
			this.date_expired = date_expired;
		}
		public String getHomepage() {
			return homepage;
		}
		public void setHomepage(String homepage) {
			this.homepage = homepage;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public String getJob_mkd() {
			return job_mkd;
		}
		public void setJob_mkd(String job_mkd) {
			this.job_mkd = job_mkd;
		}
		public boolean isPosted() {
			return posted;
		}
		public void setPosted(boolean posted) {
			this.posted = posted;
		}
		public boolean isPreview() {
			return preview;
		}
		public void setPreview(boolean preview) {
			this.preview = preview;
		}
		public String getResource_uri() {
			return resource_uri;
		}
		public void setResource_uri(String resource_uri) {
			this.resource_uri = resource_uri;
		}
		public String getSalary() {
			return salary;
		}
		public void setSalary(String salary) {
			this.salary = salary;
		}
		public String getSkills() {
			return skills;
		}
		public void setSkills(String skills) {
			this.skills = skills;
		}
		public String getSkills_mkd() {
			return skills_mkd;
		}
		public void setSkills_mkd(String skills_mkd) {
			this.skills_mkd = skills_mkd;
		}
		public String getSlug() {
			return slug;
		}
		public void setSlug(String slug) {
			this.slug = slug;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public City getCity() {
			return city;
		}
		public void setCity(City city) {
			this.city = city;
		}
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public List<Career> getCareers() {
		return objects;
	}

	public void setObjects(List<Career> objects) {
		this.objects = objects;
	}
}

/*
{
"meta": {
  "limit": 20,
  "next": "/secretapi/v1/careers/?offset=20&limit=20&format=json",
  "offset": 0,
  "previous": null,
  "total_count": 283
},
"objects": [
  {
    "about": "<p>ignore</p>",
    "about_mkd": "ignore",
    "company_name": "Shopkeep.com",
    "cost": 99,
    "date_expired": "2011-10-18T16:27:12.826151",
    "date_posted": "2011-09-18T16:27:12.826138",
    "homepage": "http://www.applytracking.com/track.aspx/a2AF",
    "id": "5",
    "job": "<p>Job Description Entry level to mid level web engineer needed for a full time\nposition at ShopKeep.com.  This is an opportunity for a young developer to\nlearn quickly under fire from a very experienced development team. You will\nget involved in web, iOS, android, and Mac/PC development.   Desired Skills &amp;\nExperience Strong skills in some or all of the following: Javascript (very\nimportant) Node.js Java Ruby iOS Python Most importantly a desire to learn all\nof the above and contribute to the team.  Please include your github profile\nwhen applying.  If you do not have a github profile please set one up. Company\nDescription ShopKeep is a Point-of-Sale transaction processing platform. The\ncore platform is written in Ruby on Rails and supports front-end 'Cash\nRegister' apps that run on iOS, Android tablets, Macs, and PCs. Point-of-Sale\nis a very exciting sector in web/mobile tech right now, and ShopKeep.com has\nproven successful in getting traction in this market. We are located in lower\nManhattan.   How to Apply: Special consideration will be paid to those that\napply through JobScore by clicking APPLY NOW.  Otherwise send a resume AND\nCOVER LETTER to jobs at shopkeep.com.     No Recruiters please.</p>",
    "job_mkd": "Job Description Entry level to mid level web engineer needed for a full time\nposition at ShopKeep.com.  This is an opportunity for a young developer to\nlearn quickly under fire from a very experienced development team. You will\nget involved in web, iOS, android, and Mac/PC development.   Desired Skills &\nExperience Strong skills in some or all of the following: Javascript (very\nimportant) Node.js Java Ruby iOS Python Most importantly a desire to learn all\nof the above and contribute to the team.  Please include your github profile\nwhen applying.  If you do not have a github profile please set one up. Company\nDescription ShopKeep is a Point-of-Sale transaction processing platform. The\ncore platform is written in Ruby on Rails and supports front-end 'Cash\nRegister' apps that run on iOS, Android tablets, Macs, and PCs. Point-of-Sale\nis a very exciting sector in web/mobile tech right now, and ShopKeep.com has\nproven successful in getting traction in this market. We are located in lower\nManhattan.   How to Apply: Special consideration will be paid to those that\napply through JobScore by clicking APPLY NOW.  Otherwise send a resume AND\nCOVER LETTER to jobs at shopkeep.com.     No Recruiters please.\n\n",
    "posted": true,
    "preview": false,
    "resource_uri": "/secretapi/v1/careers/5/",
    "salary": "",
    "skills": "<p>nah</p>",
    "skills_mkd": "nah",
    "slug": "web-engineer",
    "tags": "javascript, New York, Shopkeep.com",
    "title": "Web Engineer",
    "user": "/secretapi/v1/user/5/"
  },
*/