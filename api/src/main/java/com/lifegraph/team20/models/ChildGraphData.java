//梶が作った

package com.lifegraph.team20.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//HTTPリクエストを受け取るためのクラスここに情報の定義が集まっている
@Data
@Getter
@Setter
public class ChildGraphData {

	private long id;

	@NotNull
	private long userId;

	//	@NotNull
	////	このあたいはMySQLから引っ張ってきたい。
	////	こんな感じで
	////	select id from parent_graphs where user_id = 1
	//	private long parentId;

	@NotNull
	@Max(99)
	@Min(1)
	private int age;

	@NotNull
	@Max(100)
	@Min(-100)
	private int score;
	//うちはここのNotNull制約、つけてなかったと思う。
	//  @NotNull
	@Size(max = 100, min = 1)
	private String comment;
}