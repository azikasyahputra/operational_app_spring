package com.demo.operational.repository;

import com.demo.operational.model.PengeluaranDetail;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PengeluaranDetailRepository extends BaseRepository<PengeluaranDetail,Integer> {

    @Query("select COALESCE(SUM(mpd.biaya),0) as pengeluaran_today " +
            "from PengeluaranDetail mpd " +
            "inner join mpd.pengeluaran mph " +
            "inner join mph.invoice mih " +
            "inner join mpd.biayadetail mb " +
            "where mih.deleted ='Tidak' " +
            "and mih.dateCreated = :date " +
            "and mb.kategoriBiaya in ('Reimburs','Trucking','Dana Kerja','PPN','Jasa')")
    double sumPengeluaranToday(LocalDate date);

    @Query("select COALESCE(SUM(mpd.biaya),0) as pengeluaran_month " +
                "from PengeluaranDetail mpd " +
                "inner join mpd.pengeluaran mph " +
                "inner join mph.invoice mih " +
                "inner join mpd.biayadetail mb " +
                "where mih.deleted ='Tidak' " +
                "and YEAR(mih.dateCreated) = :year " +
                "and MONTH(mih.dateCreated) = :month " +
                "and mb.kategoriBiaya in ('Reimburs','Trucking','Dana Kerja','PPN','Jasa')")
    double sumPengeluaranThisMonth(int month, int year);

}
