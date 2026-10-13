package com.example.ktgk_2415053122347_phanmanhtung

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415053122347_phanmanhtung.databinding.ActivityChiTietChiTieuBinding

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChiTietChiTieuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title =
            "Phan Manh Tung - 2415053122347 - Quản lý chi tiêu cá nhân"
        val tenkhoanchi_347 = intent.getStringExtra("TENKHOANCHI")
        val sotien_347 = intent.getDoubleExtra("SOTIEN",-1.0)
        val ghichu_347 = intent.getStringExtra("GHICHU")?:"Chưa cập nhật"
        if (tenkhoanchi_347.isNullOrBlank()) {
            Toast.makeText(
                this,
                "Tên khoản chi không hợp lệ",
                Toast.LENGTH_SHORT
            ).show()
            finish()
            return
        }

        if (!sotien_347.isFinite() || sotien_347 <= 0.0) {
            Toast.makeText(
                this,
                "Số tiền không hợp lệ",
                Toast.LENGTH_SHORT
            ).show()
            finish()
            return
        }
        with(binding){
            tvTenKhoanChi347.text = "Tên khoản chi: $tenkhoanchi_347"
            tvSoTien347.text = "Số tiền: $sotien_347"
            tvGhiChu347.text = "Ghi chú: $ghichu_347"
        }
        binding.btnQuayVe347.setOnClickListener {
            finish()
        }
    }
}