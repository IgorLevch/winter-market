package ru.geekbraines.spring.winter.market.api;




//@NoArgsConstructor // джесоновские объекты должны быть всегда с дефолтным конструктором (джексон, когда получает/отдает объект
// в джейсоне, использует дефолтный конструктор для его формирования)

public class ProductDto {
    // ДТО - не сущность и не табличная сущность. 



    private Long id;   
    private String title;
    private int price;
    private String categoryTitle;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getCategoryTitle() {
        return categoryTitle;
    }
    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
    public ProductDto(Long id, String title, int price, String categoryTitle) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryTitle = categoryTitle;
    }
    public ProductDto() {
    }

    
    
    

}
