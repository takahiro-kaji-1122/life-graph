package com.lifegraph.team20.controller;

<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> develop
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.lifegraph.team20.models.UserData;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/life-graphs")
public class LifeGraphsContorller {
@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<UserData> userData() {
		List<UserData> userDatas = setUserData();
		return userDatas;
	}

	@Autowired

	private JdbcTemplate jdbcTemplate;

	private List<UserData> setUserData() {
		final String sql = "select * from users inner join parent_graphs on users.id = parent_graphs.user_id";
		return jdbcTemplate.query(sql, new RowMapper<UserData>() {
			public UserData mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new UserData(rs.getInt("id"), rs.getString("username"), rs.getTimestamp("updated_at"));
			}
		});
	}
}
=======
import com.lifegraph.team20.models.Content;
import com.lifegraph.team20.service.ContentService;

@RestController
@RequestMapping("/life-graph")
public class LifeGraphsContorller {
    @Autowired
    ContentService contentService;

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    Content postContent(@RequestBody Content content) {
        return contentService.postContent(content);
    }

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    List<Content> getContent() {
        return contentService.getContent();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Content putTweet(@PathVariable("id") Integer id, @RequestBody Content content) {
    	content.setId(id);
        return contentService.updateContent(content);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteContent(@PathVariable("id") Integer id) {
    	contentService.deleteContent(id);
    }
//    @RequestMapping(value = "/sample", method = RequestMethod.GET)
//	public List<UserData> userData() {
//		List<UserData> userDatas = setUserData();
//		return userDatas;
//	}
//​
//	private List<UserData> setUserData() {
//		final String sql = "select * from users inner join parent_graphs on users.id = parent_graphs.user_id";
//		return jdbcTemplate.query(sql, new RowMapper<UserData>() {
//			public UserData mapRow(ResultSet rs, int rowNum) throws SQLException{
//				return new UserData(rs.getInt("id"), rs.getString("username"), rs.getTimestamp("updated_at"));
//			}
//		});
//	}
}
>>>>>>> develop
