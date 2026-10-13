package com.example.ktgk_2415053122347_phanmanhtung

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415053122347_phanmanhtung.databinding.ActivityChiTietChiTieuBinding

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChiTietChiTieuBinding
    private var tenkhoanchi_347 = ""
    private var sotien_347 = 0.0
    private var ghichu_347= ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title =
            "Phan Manh Tung - 2415053122347 - Quản lý chi tiêu cá nhân"
        tenkhoanchi_347 = intent.getStringExtra("TENKHOANCHI").toString()
        sotien_347 = intent.getDoubleExtra("SOTIEN",-1.0)
        ghichu_347 = intent.getStringExtra("GHICHU")?:"Chưa cập nhật"
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
        binding.btnChinhSua347.setOnClickListener {
                val intent = Intent(this, ChinhSuaChiTieuActivity::class.java).apply {
                    putExtra("TENKHOANCHI",tenkhoanchi_347)
                    putExtra("SOTIEN",sotien_347)
                    putExtra("GHICHU",ghichu_347)
                }
                chinhSuaChiTieuLauncher.launch(intent)
        }
    }
    private val chinhSuaChiTieuLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            tenkhoanchi_347 = result.data?.getStringExtra("TENKHOANCHI").toString()
            sotien_347  = result.data?.getDoubleExtra("SOTIEN",-1.0)?:-1.0
            ghichu_347 = result.data?.getStringExtra("GHICHU").toString()
            with(binding){
                tvTenKhoanChi347.text = "Tên khoản chi: $tenkhoanchi_347"
                tvSoTien347.text = "Số tiền: $sotien_347"
                tvGhiChu347.text = "Ghi chú: $ghichu_347"
            }
            Toast.makeText(this,"Chỉnh sửa thành công", Toast.LENGTH_SHORT).show()
        }

    }
}