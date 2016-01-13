use test;
select * from tag

select at.tagId, count(at.articleId) articleNum
		from tag t , article_tags at
		where t.tagType = 1
			and t.tagId = at.tagId 
		
		group by at.tagId