
package com.lifegraph.team20.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChildGraphRepository {

	// データベースと接続する
	  @Autowired


	  // MySQLのデータを持ってくるライブラリ
	  JdbcTemplate jdbcTemplate;

	  public Boolean existsByUserIdAndAge(long parentId, int age) {
//		  ここ、sqlの問題書き方
//	    final String sql = "select count(*) from child_graphs where parent_id = " + parentId + " age = " + age;
	    final String sql = "select count(( parent_id = " + parentId + " and age = " + age + " ) or null) from child_graphs";
	    Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
	    return 1 >= count;
	  }

	  // ageが重複しているか確認したい
	  // リクエストできたageが同じユーザーのレコードに既に存在しているか
	  public Integer selectChild(int age) {
	    final String sql = "select count(*) from child_graphs where age = " + age;
	    Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
	    return count;
	  }

	// 子テーブルのレコードを編集する
	  // IDを持つ必要がある？？
		  public void updateChild(long parentId, int age, int score, String comment) {
			  jdbcTemplate.update( "update child_graphs set age = " + age + ", score = " + score + ", comment = '" + comment + "' where parent_id = " + parentId + " and age = "  + age);

		  }

	  // 子テーブルにレコードを追加する
	  public void addChild(long parentId, int age, int score, String comment) {
		  jdbcTemplate.update("insert into child_graphs (parent_id, age, score, comment) values (" + parentId + "," + age + ","
	        + score +  ",'" + comment + "')");
	  }
}

//↓消す

//package com.lifegraph.team20.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class ChildGraphRepository {
//
//@Autowired
////MySQLのデータを持ってくるライブラリ
//private static JdbcTemplate jdbcTemplate;
//
////ageが重複しているか確認したい
////リクエストできたageが同じユーザーのレコードに既に存在しているか
//public static Integer selectChild(int age) {
//  final String sql = "select count(*) from child_graphs where age = " + age;
//  Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
//  return count;
//}
//
////子テーブルにレコードを追加する
//public static void addChild(long id, int age, int score, String comment) {
//  final String sql = "insert into child_graphs (parent_id, age, score, comment) values ("
//      + id + "," + age + "," + score + ")";
//
//}
//}