package com.example.dto;

import com.example.model.Entry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntriesDto implements Serializable {
private Integer count;
private List<Entry> entries;
}
