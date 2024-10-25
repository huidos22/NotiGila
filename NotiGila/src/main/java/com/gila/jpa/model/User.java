package com.gila.jpa.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User implements Serializable{

	 private static final long serialVersionUID = 1L;

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    
	    @Column(nullable = false)
	    private String name;
	    
	    @Column(nullable = true)
	    private String email;
	    
	    @Column(nullable = true)
	    private String phone;
	    
	    @OneToMany
		private List<Channel> channels;
	    
	    @OneToMany
		private List<Category> subscribes;
	    
	
}
