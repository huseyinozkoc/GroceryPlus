package com.example.compose.models


data class Orders(
    val orderNo: Int,
    val orderPrice: Int,
    val orderStatus: String,
    val orderData: String
) {
}