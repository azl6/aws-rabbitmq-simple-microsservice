package com.alex6.songlogspersistencemicrosservice.songlogs.repository;

import com.alex6.songlogspersistencemicrosservice.songlogs.domain.SongRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRequestLogRepository extends JpaRepository<SongRequestLog, Long> {
}
