package com.ifood.model;

public enum OrderStatus {
    PENDING,     // Pedido recebido, aguardando confirmação do restaurante
    CONFIRMED,   // Restaurante confirmou e está preparando
    PREPARING,   // Em preparação
    OUT_FOR_DELIVERY, // Saiu para entrega
    COMPLETED,   // Entregue
    CANCELED     // Cancelado
}