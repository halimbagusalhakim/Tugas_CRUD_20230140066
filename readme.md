# Dokumentasi API Endpoint

Semua respons dari server menggunakan format JSON standar berikut:

```json
{
  "status": "success",
  "message": "Pesan dari server",
  "data": {}
}
Keterangan:

status → success jika berhasil, error jika terjadi kesalahan

message → pesan dari server

data → berisi objek, array, atau null

1. Tambah Data KTP Baru (Create)
Menyimpan data KTP baru ke database. Sistem akan memeriksa apakah Nomor KTP sudah terdaftar.

Field	Value
URL	/ktp
Method	POST
Request Body
{
  "nomorKtp": "43242",
  "namaLengkap": "halin bagus",
  "alamat": "bantul",
  "tanggalLahir": "2026-03-16",
  "jenisKelamin": "Laki-laki"
}
Response (Success - 200 OK)
{
  "status": "success",
  "message": "Data berhasil ditambahkan",
  "data": {
    "id": 1,
    "nomorKtp": "43242",
    "namaLengkap": "halin bagus",
    "alamat": "bantul",
    "tanggalLahir": "2026-03-16",
    "jenisKelamin": "Laki-laki"
  }
}
2. Ambil Semua Data KTP (Read All)
Mengambil seluruh data KTP yang tersimpan di database.

Field	Value
URL	/ktp
Method	GET
Response (Success - 200 OK)
{
  "status": "success",
  "message": "Berhasil mengambil data",
  "data": [
    {
      "id": 1,
      "nomorKtp": "43242",
      "namaLengkap": "halin bagus",
      "alamat": "bantul",
      "tanggalLahir": "2026-03-16",
      "jenisKelamin": "Laki-laki"
    }
  ]
}
3. Ambil Data KTP Berdasarkan ID (Read By ID)
Mengambil satu data KTP berdasarkan ID.

Field	Value
URL	/ktp/{id}
Method	GET
Contoh:

/ktp/1
Response (Success - 200 OK)
{
  "status": "success",
  "message": "Data ditemukan",
  "data": {
    "id": 1,
    "nomorKtp": "43242",
    "namaLengkap": "halin bagus",
    "alamat": "bantul",
    "tanggalLahir": "2026-03-16",
    "jenisKelamin": "Laki-laki"
  }
}
4. Perbarui Data KTP (Update)
Mengubah data KTP yang sudah ada berdasarkan ID.

Field	Value
URL	/ktp/{id}
Method	PUT
Contoh:

/ktp/1
Request Body
{
  "nomorKtp": "43242",
  "namaLengkap": "Halin Bagus",
  "alamat": "Bantul, Yogyakarta",
  "tanggalLahir": "2026-03-16",
  "jenisKelamin": "Laki-laki"
}
Response (Success - 200 OK)
{
  "status": "success",
  "message": "Data berhasil diperbarui",
  "data": {
    "id": 1,
    "nomorKtp": "43242",
    "namaLengkap": "Halin Bagus",
    "alamat": "Bantul, Yogyakarta",
    "tanggalLahir": "2026-03-16",
    "jenisKelamin": "Laki-laki"
  }
}
5. Hapus Data KTP (Delete)
Menghapus data KTP dari database berdasarkan ID.

Field	Value
URL	/ktp/{id}
Method	DELETE
Contoh:

/ktp/1
Response (Success - 200 OK)
{
  "status": "success",
  "message": "Data berhasil dihapus",
  "data": null
}