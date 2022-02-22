/**
 * 
 */
package com.practice.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swjana
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	private Long id;

	private String name;

	private Integer tier;

}
