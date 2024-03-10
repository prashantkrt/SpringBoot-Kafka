package com.myLearning.wikimedia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "wikimedia_recentchange")
@Data
@ToString
public class Wikimedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Column(name="media")
	private String wikiEventData;
}
