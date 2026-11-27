package com.starbank.recommendationservice.repository

import com.starbank.recommendationservice.entity.RuleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RuleRepository : JpaRepository<RuleEntity?, UUID?>