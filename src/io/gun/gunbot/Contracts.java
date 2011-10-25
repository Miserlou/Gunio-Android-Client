package io.gun.gunbot;

import java.util.List;

public class Contracts {
	private int limit;
	private String next;
	private int offset;
	private String previous;
	private int total_count;
	
	private List<Contract> objects;
	
	public class Contract{
		private boolean awarded;
		private String date_expired;
		private String date_posted;
		private String description;
		private String description_mkd;
		private String id;
		private boolean preview;
		private String project_homepage;
		private String proof;
		private String proof_mkd;
		private String requirements;
		private String requirements_mkd;
		private String slug;
		private String tags;
		private String title;
		private User user;
		public class User{
			private String username;

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}
		}
		private int value;
		public boolean isAwarded() {
			return awarded;
		}
		public void setAwarded(boolean awarded) {
			this.awarded = awarded;
		}
		public String getDate_expired() {
			return date_expired;
		}
		public void setDate_expired(String date_expired) {
			this.date_expired = date_expired;
		}
		public String getDate_posted() {
			return date_posted;
		}
		public void setDate_posted(String date_posted) {
			this.date_posted = date_posted;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDescription_mkd() {
			return description_mkd;
		}
		public void setDescription_mkd(String description_mkd) {
			this.description_mkd = description_mkd;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public boolean isPreview() {
			return preview;
		}
		public void setPreview(boolean preview) {
			this.preview = preview;
		}
		public String getProject_homepage() {
			return project_homepage;
		}
		public void setProject_homepage(String project_homepage) {
			this.project_homepage = project_homepage;
		}
		public String getProof() {
			return proof;
		}
		public void setProof(String proof) {
			this.proof = proof;
		}
		public String getProof_mkd() {
			return proof_mkd;
		}
		public void setProof_mkd(String proof_mkd) {
			this.proof_mkd = proof_mkd;
		}
		public String getRequirements() {
			return requirements;
		}
		public void setRequirements(String requirements) {
			this.requirements = requirements;
		}
		public String getRequirements_mkd() {
			return requirements_mkd;
		}
		public void setRequirements_mkd(String requirements_mkd) {
			this.requirements_mkd = requirements_mkd;
		}
		public String getSlug() {
			return slug;
		}
		public void setSlug(String slug) {
			this.slug = slug;
		}
		public String getTags() {
			return tags;
		}
		public void setTags(String tags) {
			this.tags = tags;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
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

	public List<Contract> getContracts() {
		return objects;
	}

	public void setObjects(List<Contract> objects) {
		this.objects = objects;
	}
}

/*
{
{
  "meta": {
    "limit": 20,
    "next": null,
    "offset": 0,
    "previous": null,
    "total_count": 2
  },
  "objects": [
    {
      "awarded": false,
      "date_expired": "2011-08-29T16:57:22.846757",
      "date_posted": "2011-08-29T16:57:22.846748",
      "description": "<p>ex: I need somebody to create a Python library which implements the OAuth2 specification. It must have complete coverage of all test cases.</p>",
      "description_mkd": "ex: I need somebody to create a Python library which implements the OAuth2 specification. It must have complete coverage of all test cases.",
      "id": "1",
      "preview": false,
      "project_homepage": "http://github.com/",
      "proof": "",
      "proof_mkd": "",
      "requirements": "<p>ex: The project must meet the following requirements: \n<em> Written in Python. \n</em> 100% working implementation of the OAuth2 specification.\n<em> Code style must adhere to PEP-8.\n</em> All functions must be well-commented.\n<em> Code must be released under the BSD license.\n</em> Examples must be provided.</p>",
      "requirements_mkd": "ex: The project must meet the following requirements: \r\n* Written in Python. \r\n* 100% working implementation of the OAuth2 specification.\r\n* Code style must adhere to PEP-8.\r\n* All functions must be well-commented.\r\n* Code must be released under the BSD license.\r\n* Examples must be provided.",
      "resource_uri": "/secretapi/v1/contracts/1/",
      "slug": "shoooooot",
      "tags": "asdf",
      "title": "Shoooooot",
      "user": "/secretapi/v1/user/2/",
      "value": 99
    },
*/