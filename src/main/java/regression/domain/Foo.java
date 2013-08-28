package regression.domain;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Foo {
    private long id;
    private long category;
    private String categoryName;
    private BigDecimal value1;
    private int value2;


    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    @Basic
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    public BigDecimal getValue1() {
        return value1;
    }

    public void setValue1(BigDecimal value1) {
        this.value1 = value1;
    }

    @Basic
    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
