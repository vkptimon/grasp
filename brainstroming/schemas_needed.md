## Major schemas

- User
  - id(primary key)
  - email
  - first_name
  - last_name
  - pronouns
  - profession/job_role_name
  - bio/description
  - profile_picture
  - github_account_integration(to link/signin using their github acc) // kept on hold for now
  - isSubscribedToNewsLetter
  - created_at(timestamp)
  *new additions*
  - is_active(for soft delete feature of the user account)
  - username(for sending in the url)

- Follow(information related to followers and following count)
  - id(primary key)
  - follower_id(FK to User)
  - following_id(FK to User)
  - created_at(timestamp)

- Post(metainfo about the post)
  - id(primary key)
  - title
  - description/content
  - author_id(from users, foreign key)
  - published_at(datetime stamp)
  - reading_time('x' time to read and such)
  - view_count(int)
  - created_at(timestamp)
  *new addition*
  - slug(string; url friendly verison of the post title)
  - status(enum; DRAFT, PUBLISHED, ARCHIVED)
  - updated_at(timestamp; imp for showing the last edit time and cache invalidation)

- Reactions/Impressions on the post(likes, views and other impressions on the site)
  - id(primary key)
  - post_id(foreign key)
  - user_id(foreign key)
  - reaction_type(like, cheer, insightful)
  - count(int)

- Comments(metainfo about the comments)
  - id(primary key)
  - user_id(foreign key)
  - post_id(foreign key)
  - content/description
  - postedAt(int)
  - created_at(timestamp)

- Bookmarks(metainfo related to bookmarks)
  - id(primary key)
  - user_id(foreign key)
  - post_id(foreign key)
  - bookmark_list_name(a list where the post is saved to)
  - created_at(timestamp)

- Tags(optional)
  - id(primary key)
  - tag_name

- any other schema can be discussed
- id should be of alphanumeric(would be helpful during debugging process in my opinion)
- createdAt can be used for filtering the logs when error occurs, if the timestamp is in human-readable format like the ISO 8601 without the milliseconds, it would be a lot better.