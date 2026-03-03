### Needed controllers for the blog

- User
	- `getAllUsers`: to get all the users; GET
	- `getUserById`: getting a specific user's detail based on the sid or email(email is not the primary key); we will be passing the sid or email in the query param/in the payload(depending on which is the optimal way to perform); GET
	- `createUser`: creating a new user; we will be only supporting sign up using email or gmail for now(but email only for phase 1, google auth will be added latter); all the contents(majorly first name, last name, email, password) collected from the sign-up page; POST
	- `updateUserInfo`: updating the attributes of the user, will aslo allow change of email(need to handle it's linkage in that case); we will be passing the sid and also the list of attributes that are changed from the profile; PUT
	- `deleteUserById`: delete all the information related to them, will soft-delete in the backend with cleanup period of 2 weeks, where after they couldn't recover their account; we will be sending the sid of the user; DELETE

- Post
	- `getAllPosts`: to get all the posts; GET
	- `getPostById`: to get a specific post by it's id; post id will be sent; GET
	- `getPostsByAuthor`: fetch all the posts made by a user; userId/authorId will be sent and all the posts mapped to the user as author will be displayed in their posts section; GET
	- `createPost`: create a post with the contents like title, postBody and timeToRead(this should be calculated from the system based on the no of words and images in the posts); POST
	- `getPostsInABookmarkedList`: fetch all the posts in a bookmarked list; send the bookmark folder id and fetch all the posts saved/attached to it; GET
	- `bookmarkPostToList`: add a post to a bookmarking list; send the post id and the bookmark folder/list id; PUT
	- `deletePost`: remove a post if you want; send the post id; DELETE

- Comment
	- `getCommentsByPostId`: to get all the comments based the post id; send the post id; GET
	- `createComment`: create a new comment; userId/authorId, post id will be sent; POST
	- `updateComment`: update the content of the comment; send the new comment body and also the user id, post id; PUT
	- `deleteComment`: delete the comment; send the comment id; DELETE

- Bookmark
	- `getBookmarksByUser`: fetch all the bookmark folders/lists for a user; send the userId; GET
	- `createBookmarkList`: create a folder/list to save posts to watch later; send the userId; POST
	- `addPostToBookmarkList`: add a new post to the bookmark folder/list; send the postId, userId, bookmarkListId; PUT
	- `deleteBookmarkList`: remove the bookmark list; send the bookmarkListId and userId; DELETE

- FollowInfo
	- `getFollewersCountForUser`: fetch the count of the followers in the user profile(but do we need to call an API for this, maybe it can be done using a SQL join operation)
	- maybe i guess it can be done using JOIN operation; is it better than an API call?

- Reactions
	- i guess this can also be done based on the JOIN operation with the Post entity