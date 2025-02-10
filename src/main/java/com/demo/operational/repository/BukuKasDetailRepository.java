package com.demo.operational.repository;

import com.demo.operational.model.BukuKasDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuKasDetailRepository extends BaseRepository<BukuKasDetail,Integer> {
    @Query("select COALESCE((SUM(mbkd.biayaDebit) + SUM(mbkd.biayaKredit)),0) as total_bruto_month " +
                "from BukuKasDetail mbkd " +
                "left join mbkd.referensi mr " +
                "where mr.flagBukuKas IN ('Pendapatan Jasa','Pendapatan Operasional') " +
                "and mbkd.deleted = 'Tidak' " +
                "and mr.deleted = 'Tidak' " +
                "and MONTH(mbkd.dateCreated) = :month " +
                "and YEAR(mbkd.dateCreated) = :year ")
    double sumTotalBrutoThisMonth(int month, int year);

    @Query("select COALESCE(SUM(mbkd.biayaDebit),0) as total_biaya_month " +
                "from BukuKasDetail mbkd " +
                "left join mbkd.referensi mr " +
                "where mr.flagBukuKas IN ('Biaya') " +
                "and mr.idReferensi <> 50 " +
                "and mbkd.deleted = 'Tidak' " +
                "and mr.deleted = 'Tidak' " +
                "and MONTH(mbkd.dateCreated) = :month " +
                "and YEAR(mbkd.dateCreated) = :year ")
    double sumTotalBiayaThisMonth(int month, int year);


    @Query("select COALESCE(SUM(mbkd.biayaDebit), 0) as total_kewajiban_month " +
            "from BukuKasDetail mbkd " +
            "left join mbkd.referensi mr " +
            "where mr.idReferensi in (47, 48, 49) " +
            "and mbkd.deleted = 'Tidak' " +
            "and mr.deleted = 'Tidak' " +
            "and MONTH(mbkd.dateCreated) = :month " +
            "and YEAR(mbkd.dateCreated) = :year")
    double sumTotalKewajibanThisMonth(@Param("month") int month, @Param("year") int year);
}
