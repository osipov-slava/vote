package vote.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "menus", uniqueConstraints = {@UniqueConstraint(columnNames = {"date", "restaurant_id", "dish_id"}, name = "unique_menu")})
public class Menu extends AbstractBaseEntity {
    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date = LocalDate.now();

    @JoinColumn(name = "restaurant_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Restaurant restaurant;

    @JoinColumn(name = "dish_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Dish dish;

    public Menu() {
    }

    public Menu(Integer id, LocalDate date, Restaurant restaurant, Dish dish) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
        this.dish = dish;
    }

    public Menu(Integer id, Restaurant restaurant, Dish dish) {
        super(id);
        this.restaurant = restaurant;
        this.dish = dish;
    }

    public LocalDate getDate() {
        return date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", date=" + date +
                ", restaurant=" + restaurant +
                ", dish=" + dish +
                '}';
    }
}
