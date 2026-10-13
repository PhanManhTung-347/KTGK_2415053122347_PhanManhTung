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
    private var khoanchi: KhoanChi?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title =
            "Phan Manh Tung - 2415053122347 - Quản lý chi tiêu cá nhân"
        val tenKhoanChi_347 = intent.getStringExtra("TENKHOANCHI").toString()
        val soTien_347 = intent.getDoubleExtra("SOTIEN",-1.0)
        val ghiChu_347 = intent.getStringExtra("GHICHU")?:"Chưa cập nhật"
        val trangthai_347 = intent.getBooleanExtra("TRANGTHAI",false)
        binding.rdoTrangThai.isEnabled = false
        if (tenKhoanChi_347.isNullOrBlank()) {
            Toast.makeText(
                this,
                "Tên khoản chi không hợp lệ",
                Toast.LENGTH_SHORT
            ).show()
            finish()
            return
        }
        else
        if (!soTien_347.isFinite() || soTien_347 <= 0.0) {
            Toast.makeText(
                this,
                "Số tiền không hợp lệ",
                Toast.LENGTH_SHORT
            ).show()
            finish()
            return
        }
        else {
            khoanchi = KhoanChi(1,"$tenKhoanChi_347", soTien_347, "$ghiChu_347",trangthai_347)
            khoanchi?.let{ kc->
                with(binding){
                    tvTenKhoanChi347.text = "Tên khoản chi: ${kc.tenKhoanChi_347}"
                    tvSoTien347.text = "Số tiền: ${kc.soTien_347}"
                    tvGhiChu347.text = "Ghi chú: ${kc.ghiChu_347}"
                    rdoTrangThai.isChecked = trangthai_347
                }
            }
        }

        binding.btnQuayVe347.setOnClickListener {
            khoanchi?.let { kc->
                val resultIntent = Intent().apply {
                    putExtra("TENKHOANCHI",kc.tenKhoanChi_347)
                    putExtra("SOTIEN",kc.soTien_347)
                    putExtra("GHICHU",kc.ghiChu_347)
                    putExtra("TRANGTHAI", kc.daThanhToan_347)
                }
                setResult(RESULT_OK,resultIntent)
            }
            finish()
        }
        binding.btnChinhSua347.setOnClickListener {
            khoanchi?.let { kc->
                val intent = Intent(this, ChinhSuaChiTieuActivity::class.java).apply {
                    putExtra("TENKHOANCHI",kc.tenKhoanChi_347)
                    putExtra("SOTIEN",kc.soTien_347)
                    putExtra("GHICHU",kc.ghiChu_347)
                    putExtra("TRANGTHAI",kc.daThanhToan_347)
                }
                chinhSuaChiTieuLauncher.launch(intent)
            }
        }
    }
    private val chinhSuaChiTieuLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            val tenkhoanchi_347 = result.data?.getStringExtra("TENKHOANCHI")?:""
            val sotien_347  = result.data?.getDoubleExtra("SOTIEN",-1.0)?:-1.0
            val ghichu_347 = result.data?.getStringExtra("GHICHU")?:""
            val trangthai_347 = result.data?.getBooleanExtra("TRANGTHAI",false)?:false
            khoanchi= khoanchi?.copy(tenKhoanChi_347 = tenkhoanchi_347, soTien_347 = sotien_347, ghiChu_347 = ghichu_347, daThanhToan_347 = trangthai_347)
            with(binding){
                tvTenKhoanChi347.text = "Tên khoản chi: $tenkhoanchi_347"
                tvSoTien347.text = "Số tiền: $sotien_347"
                tvGhiChu347.text = "Ghi chú: $ghichu_347"
                rdoTrangThai.isChecked = trangthai_347
            }
            Toast.makeText(this,"Chỉnh sửa thành công", Toast.LENGTH_SHORT).show()
        }

    }
}