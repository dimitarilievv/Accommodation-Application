package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.enumerations.Category;

public class CategoryCountDto {
    private Category category;
    private Long count;

    public CategoryCountDto(Category category, Long count) {
        this.category = category;
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public Long getCount() {
        return count;
    }
}