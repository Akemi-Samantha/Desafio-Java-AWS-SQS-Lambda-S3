package com.estudo.desafiojavaaws.domain.product;

public record ProductDto(String title, String description, String ownerId, Integer price, String categoryId) {
}
