package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        initTestData();
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection<Searchable> getAllSearchables() {
        List<Searchable> all = new ArrayList<>();
        all.addAll(products.values());
        all.addAll(articles.values());
        return all;
    }

    private void initTestData() {
        UUID id1 = UUID.randomUUID();
        products.put(id1, new SimpleProduct(id1, "milk", 80));

        UUID id2 = UUID.randomUUID();
        products.put(id2, new SimpleProduct(id2, "egg", 100));

        UUID id3 = UUID.randomUUID();
        products.put(id3, new DiscountedProduct(id3, "cookie", 150, 10));

        UUID id4 = UUID.randomUUID();
        products.put(id4, new FixPriceProduct(id4, "sugar"));


        UUID id5 = UUID.randomUUID();
        articles.put(id5, new Article(id5, "Как готовить омлет", "Рецепт с яйцами и молоком..."));

        UUID id6 = UUID.randomUUID();
        articles.put(id6, new Article(id6, "Выпечка cookies", "Классический рецепт печенья..."));
    }
    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }
}
