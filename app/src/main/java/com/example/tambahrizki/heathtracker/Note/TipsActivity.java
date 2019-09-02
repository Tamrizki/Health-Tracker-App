package com.example.tambahrizki.heathtracker.Note;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tambahrizki.heathtracker.AdapterNoteDeskrispsi;
import com.example.tambahrizki.heathtracker.DbHelper;
import com.example.tambahrizki.heathtracker.MenuActivity;
import com.example.tambahrizki.heathtracker.R;

import java.util.ArrayList;

public class TipsActivity extends AppCompatActivity {


    //    RecyclerView recyclerView;
//    ArrayList<DataNote> getArray = new ArrayList<>();
    String deskripsiKurus[] = {"Berikut ini cara menggemukan badan dengan cepat yang bisa anda lakukan setiap hari di rumah:\n" +
        "1. Minum susu\n" +
        "Selain menyehatkan tubuh, susu juga mampu membantu menggemukkan badan. Namun tidak semua jenis susu dapat menggemukan badan.\n" +
        "Cara menggemukan badan dengan susu bisa dilakukan dengan memilih susu full cream. Susu ini jauh lebih efektif untuk menggemukan badan daripada susu tinggi kalsium atau susu jenis lainnya. Untuk mendapatkan hasil yang lebih efektif, susu sebaiknya diminum dua kali sehari setelah bangun tidur dan sebelum tidur.\n" +
        "Selain susu murni, kamu juga bisa mengonsumsi berbagai susu olahan. Misalnya kamu bisa mengkonsumsi yogurt, puding, dan es krim. Anda bisa minum susu atau olahannya sebagai minuman penutup sesudah makan.\n" +
        "2. Mengunyah makanan\n" +
        "Ketika makanan berada di dalam mulut, biasakan untuk mengunyah makanan tersebut sampai halus. Hal ini penting karena dapat mempermudah kinerja lambung Anda.\n" +
        "Mengapa Anda perlu menguyah makanan sampai halus? Pada dasarnya makanan yang halus akan lebih mudah diserap nutrisinya oleh tubuh. Jika Anda bosan, Anda dapat mengkonsumsi jus atau smoothies.\n" +
        "3. Makan teratur\n" +
        "Makan teratur atau tidak ternyata juga dapat berpengaruh pada berat badan. Yang terutama adalah sarapan di pagi hari.\n" +
        "Tips menggemukan badan yang sehat adalah dengan tidak melewatkan waktu sarapan di pagi hari. Selain itu sarapan pagi juga dapat memberi energi untuk beraktivitas. Makananan yang bernutrisi tinggi tentu saja akan membantu proses menggemukkan badan Anda.\n" +
        "Makan lima sampai enam kali dengan porsi yang kecil lebih baik dibandingkan makan tiga kali sehari dengan porsi besar. Hal ini disebabkan karena tubuh akan lebih mudah memproses asupan makanan Anda.\n" +
        "4. Jenis makanan\n" +
        "Cara menggemukan badan selanjutnya adalah melalui pemilihan jenis makanan. Makanan yang dikonsumsi tidak boleh sembarangan.\n" +
        "Pilihlah jenis makanan yang sesuai dengan aktivitas Anda. Jika dalam kegiatan sehari-hari Anda banyak melakukan aktivitas, maka konsumsilah makanan yang banyak mengandung lemak atau karbohidrat. Misalnya seperti nasi, kentang, alpukat, dan roti. Jika kelebihan makanan, maka lemak dan karbohidrat akan ditimbun sehingga akhirnya dapat menaikkan berat badan.\n" +
        "5. Istirahat\n" +
        "Tubuh memerlukan waktu istirahat minimal 8 jam. Oleh sebab itu pastikan bahwa Anda cukup beristirahat dan jangan terbiasa begadang.\n" +
        "Selain itu usahakan untuk tidur siang. Dengan tidur siang yang cukup maka tubuh Anda akan menjadi sehat dan penyerapan makanan dapat berlangsung secara optimal. Begadang merupakan salah satu yang harus Anda hindari jika ingin menggemukan badan. Apalagi begadang juga dapat meningkatkan risiko terkena penyakit.\n" +
        "6. Kurangi merokok\n" +
        "Jika Anda selama ini merokok, maka kurangi kebiasaan merokok. Rokok sangat berbahaya bagi tubuh.\n" +
        "Selain membuat tubuh menjadi tidak sehat, rokok juga dapat menghambat kenaikkan berat badan sehingga Anda sulit gemuk. Apalagi rokok dapat menjadi pemicu penurunan nafsu makan. Jika demikian maka nutrisi dan kebutuhan gizi tentu saja akan menurun.\n" +
        "7. Konsumsi putih telur\n" +
        "Telur merupakan makanan yang kaya protein sehingga sangat baik untuk membantu mempercepat proses penggemukan badan.\n" +
        "Anda dapat mulai membiasakan konsumsi putih telur secara teratur setiap hari. Sangat disarankan untuk mengkonsumsi telur di pagi hari. Telur merupakan makanan yang mengandung tinggi protein dan juga kalori. Tentu saja Anda harus menjaga jumlah telur yang dikonsumsi.\n" +
        "8. Tambahkan kalori sehat\n" +
        "Anda dapat meningkatkan kalori dengan menambahkan kacang atau taburan biji, keju, dan lauk sehat.\n" +
        "Anda tidak perlu mengubah pola makan secara drastis demi menggemukan badan. Cobalah almond, biji bunga matahari, buah, atau gandum utuh, dan roti gandum. Yang perlu diperhatikan adalah menghindari gorengan. Walau bisa dijadikan sebagai cara menggemukan badan, gorengan memiliki potensi meningkatkan kolesterol yang tidak baik bagi tubuh Anda.\n" +
        "9. Konsumsi nutrisi yang padat\n" +
        "Alih-alih mengonsumsi nol kalori dan junk food, makanlah makanan yang kaya nutrisi. Pertimbangkan daging berprotein tinggi, yang dapat membantu membangun otot.\n" +
        "Anda juga dapat memilih karbohidrat bergizi, seperti beras merah dan biji-bijian lainnya. Makanan ini membantu memastikan tubuh menerima makanan sebanyak mungkin, bahkan jika Anda berurusan dengan nafsu makan yang berkurang.\n" +
        "10. Olahraga\n" +
        "Olahraga dipercaya dapat menurunkan berat badan, namun olahraga ternyata dapat membantu menaikkan berat badan dan cara menggemukan badan yang ampuh.\n" +
        "Selain sebagai cara menggemukkan badan, olahraga yang teratur juga dapat menyehatkan badan Anda. Biasanya setelah olahraga, nafsu makan Anda akan meningkat. Dengan demikian asupan nutrisi dan kalori dalam tubuh juga akan ikut meningkat juga.\n" +
        "11. Periksa kesehatan\n" +
        "Jika Anda sudah pernah gemuk dan sekarang kurus, Anda perlu mencoba cek kesehatan Anda.\n" +
        "Ada beberapa gangguan atau penyakit yang bisa menghalangi Anda menggendutkan badan. Jika Anda tidak mengalami gangguan kesehatan atau penyakit, maka cara menggemukkan badan di atas dapat membuat Anda untuk menggemukkan badan dengan cepat. Ada baiknya Anda melakukan konsultasi dengan ahli gizi atau dokter sebelum mengikuti proses cara menggemukan badan.\n" +
        "Nah, itu dia tips cara menggemukan badan dengan cepat yang bisa Anda coba di rumah, ingat! Tetap terapkan makan sehat ya, Teman Sehat!\n"};
    String deskripsiGemuk[] = {"Berikut ini adalah beberapa makanan rendah kalori yang baik dikonsumsi untuk menjaga berat badan Anda.\n" +
            "•\tSayur-sayuran dan buah-buahan\n" +
            "Sudah menjadi rahasia umum jika buah dan sayur adalah dua jenis makanan yang sehat dan pastinya baik untuk tubuh. Sayuran mengandung kalori yang rata-rata berjumlah kurang dari 100 kalori per takaran saji. Misalnya saja brokoli, timun, wortel, asparagus, kembang kol, seledri, tomat, dan kubis.\n" +
            "Sedangkan buah-buahan yang memiliki kandungan kalori yang rendah, yaitu semangka, stroberi, bluberi, anggur, kismis, jeruk bali, lemon, dan jeruk nipis.\n" +
            "Untuk camilan, mengonsumsi secangkir (sekitar 175 gram) anggur lebih sehat daripada kismis, karena kalori dalam secangkir anggur setara dengan seperempat cangkir kismis. Selain itu, mengonsumsi anggur akan membuat Anda merasa lebih kenyang dibandingkan mengonsumsi kismis.\n" +
            "•\tKacang-kacangan dan biji-bijian\n" +
            "Selain sayur dan buah, kacang-kacangan dan biji-bijian juga termasuk makanan rendah kalori. Misalnya saja, segenggam kacang almond (sekitar 10-15 kacang almond) hanya mengandung sekitar 80 kalori, selain itu mengonsumsi 10 biji kacang pistachio hanya memberi kalori sekitar 40 kalori. Jika lapar di antara jam makan, Anda bisa mengonsumsi popcorn yang sangat rendah kalorinya, selama tidak ditambahkan mentega atau gula. Tiga setengah cangkir popcorn hanya mengandung 100 kalori.\n" +
            "•\tIkan\n" +
            "Ikan juga termasuk dalam makanan rendah kalori. Selain itu, kandungan omega-3 yang terdapat dalam ikan mengandung banyak manfaat bagi kesehatan, termasuk untuk mengurangi peradangan dan memperbaiki kesehatan jantung. Beberapa jenis ikan yang rendah kalorinya adalah salmon (116 kalori per 100 gram), ikan kod (82 kalori per 100 gram), tongkol, dan tuna. Pastikan ikan yang dikonsumsi, diolah dengan cara yang sehat juga, yaitu ditumis dengan sedikit minyak atau dikukus. Hindari menggoreng ikan.\n" +
            "Jika Anda kurang suka mengonsumsi ikan, jenis daging lain yang rendah lemak adalah daging yang berwarna putih, seperti dada ayam. Pastikan Anda menyisihkan kulit ayam yang tinggi kalori dan rendah nutrisinya.\n"};
    String deskripsiIdeal[] = {"Tidak perlu ke gym setiap hari atau diet mati-matian untuk menjaga tubuh Anda tetap ideal. Memperbaiki gaya hidup sehari-hari seperti membiasakan sarapan, makan dalam porsi kecil dan lainnya juga akan menjaga tubuh Anda tetap langsing. Ingin tahu kebiasaan apa lagi yang bisa menjaga berat badan tanpa olahraga? Simak caranya yang dikutip dari Red Book berikut ini:\n" +
            "\n" +
            "1. Sayur\n" +
            "Pastikan setengah dari porsi makanan Anda terisi sayuran. Sayur-sayuran mengandung serat dan air yang akan memperlancar pencernaan dan menjaga berat tubuh Anda.\n" +
            "\n" +
            "2. Porsi Kecil\n" +
            "Jika Anda ingin tetap langsing, selalu pesan makanan Anda dalam porsi kecil. Ahli gizi, Stephanie Middleberg, MS, RD, CDN menyarankan untuk selalu memesan dalam ukuran kecil, baik untuk kopi, sup, atau frozen yogurt.\n" +
            "\n" +
            "3. Salad atau Sup\n" +
            "Sebelum masuk ke menu utama, jangan lupa untuk memesan salad atau sup dibanding sekeranjang roti atau lainnya. Salad dan sup mengandung sedikit kalori namun bisa mengisi perut, sehingga Anda tidak butuh makan banyak saat makanan utama keluar nanti.\n" +
            "\n" +
            "4. Sisakan Makanan\n" +
            "Sebelum mulai makan, biasakan untuk menyisihkan seperempat porsi makanan Anda. Bagi sisa makanan Anda dengan teman atau pasangan ketika makan bersama.\n" +
            "\n" +
            "5. Minum Banyak Air\n" +
            "Kadang Anda tidak menyadari apakah Anda benar-benar lapar, atau hanya haus? Untuk itu, cobalah minum segelas air tiap saat Anda merasa ingin mengkonsumsi sesuatu. Anda juga bisa tambahkan perasan lemon untuk memberi rasa dan tambahan vitamin.\n" +
            "\n" +
            "6. Hindari Makan di Depan Televisi\n" +
            "Ketika menonton film, memang menyenangkan jika ditemani cemilan favorit. Namun tanpa disadari, Anda akan terus mengunyah dan sulit untuk berhenti makan. Jika perut terasa lapar ketika sedang menonton, ambil cemilan yang kaya akan serat atau makanlah buah-buahan.\n" +
            "\n" +
            "7. Gandum\n" +
            "Mengkonsumsi makanan yang mengandung gandum utuh seperti roti gandum, akan lebih baik dibanding roti tawar biasa. Gandum akan membuat perut kenyang lebih lama, menjaga level gula darah dan memberi tubuh vitamin dan mineral. Berbeda dengan roti tawar yang terbuat dari tepung terigu yang akan berubah menjadi lemak jika tidak segera dibakar.\n" +
            "\n" +
            "8. Sarapan\n" +
            "Sebelum memulai aktifitas sehari-hari, jangan lupa untuk sarapan. Sarapan bermanfaat untuk proses metabolisme dan juga mencegah Anda untuk mengonsumsi kalori yang berlebih pada malam hari.\n" +
            "\n" +
            "9. Mulai Berolahraga\n" +
            "Olahraga sangat baik untuk kesehatan dan juga menjaga bentuk tubuh. Tidak perlu selalu ke gym untuk tetap sehat, mulailah dengan kebiasaan sehari-hari seperti berjalan kaki atau naik-turun tangga minimal 3 jam dalam seminggu.\n" +
            "\n" +
            "10. Hindari Makan Menjelang Tidur\n" +
            "Cara lain untuk menjaga berat badan adalah tidak makan sebelum Anda tidur. Kalori memberi energi pada tubuh, dan Anda tidak memerlukan energi ketika tidur.\n" +
            "\n" +
            "11. Jangan Konsumsi Gula Sachet\n" +
            "Menikmati kopi atau teh akan terasa kurang tanpa manisnya gula. Namun hindari menggunakan gula kemasan atau sachet. Cukup satu sendok teh gula bila Anda ingin menambahkan rasa manis pada minuman Anda, atau bisa juga mengganti gula dengan madu atau sirup maple.\n" +
            "\n" +
            "12. Makanan Kecil\n" +
            "Sebelum pergi jalan-jalan dengan orang terdekat, pastikan Anda memakan sesuatu seperti buah atau sayur agar perut tidak terasa kosong. Jika Anda pergi dengan keadaan perut kosong, Anda akan memesan makanan yang lebih dari kebutuhan Anda.\n"};
    TextView jdl,tanya, desk;
    String judul [] = {"Cara mengatasi badan yang Kurus", "Cara Menjaga agar tetap Ideal", "Cara mengatasi badan yang Gemuk"};
    String tanyahasil[]={"Hasil BMI anda Kurus?", "Hasil BMI anda Ideal?", "Hasil BMI anda Gemuk?"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        jdl = findViewById(R.id.txt_jdl_note);
        tanya = findViewById(R.id.txt_tanya_hasil);
        desk = findViewById(R.id.txt_deskr);
        Intent intent = getIntent();
        int nomer = intent.getIntExtra("nomer", 0);

        if (nomer == 3){
            jdl.setText(judul[nomer-1]);
            tanya.setText(tanyahasil[nomer-1]);
            desk.setText(deskripsiKurus[0]);
        }else if (nomer == 2){
            jdl.setText(judul[nomer-1]);
            tanya.setText(tanyahasil[nomer-1]);
            desk.setText(deskripsiIdeal[0]);
        }else if (nomer == 1){
            jdl.setText(judul[nomer-1]);
            tanya.setText(tanyahasil[nomer-1]);
            desk.setText(deskripsiGemuk[0]);
        }
        //        recyclerView = findViewById(R.id.recyclerView_Note);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        getArray.add( new DataNote("Pola Makan","Kunyah makanan secara perlahan. Anda bisa memulai dengan mengunyah makanan secara perlahan agar mengasup rendah kalori. ...\n" +
//                "Kurangi makan camilan. ...\n" +
//                "Hindari terlalu sering order makanan di luar. ...\n" +
//                "Kurangi konsumsi garam. ...\n" +
//                "Hindari minum soda. ...\n"+
//                "Kunyah makanan secara perlahan. Anda bisa memulai dengan mengunyah makanan secara perlahan agar mengasup rendah kalori. ...\n" +
//                "Kurangi makan camilan. ...\n" +
//                "Hindari terlalu sering order makanan di luar. ...\n" +
//                "Kurangi konsumsi garam. ...\n" +
//                "Hindari minum soda. ...\n" +
//                "Hati-hati dengan minuman alkohol."+
//                "Kunyah makanan secara perlahan. Anda bisa memulai dengan mengunyah makanan secara perlahan agar mengasup rendah kalori. ...\n" +
//                "Kurangi makan camilan. ...\n" +
//                "Hindari terlalu sering order makanan di luar. ...\n" +
//                "Kurangi konsumsi garam. ...\n" +
//                "Hindari minum soda. ...\n" +
//                "Hati-hati dengan minuman alkohol."));
//        getArray.add( new DataNote("Pola Makan","Kunyah makanan secara perlahan. Anda bisa memulai dengan mengunyah makanan secara perlahan agar mengasup rendah kalori. ...\n" +
//                "Kurangi makan camilan. ...\n" +
//                "Hindari terlalu sering order makanan di luar. ...\n" +
//                "Kurangi konsumsi garam. ...\n" +
//                "Hindari minum soda. ...\n" +
//                "Hati-hati dengan minuman alkohol."));
//        LinearLayoutManager layoutManager
//                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        AdapterNoteDeskrispsi adapter = new AdapterNoteDeskrispsi(getArray, TipsActivity.this);
//        recyclerView.setAdapter(adapter);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
