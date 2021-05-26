package com.shiveenp.taggit

import com.shiveenp.taggit.db.TaggitRepoEntity
import com.shiveenp.taggit.db.TaggitUserEntity
import com.shiveenp.taggit.models.Metadata
import com.shiveenp.taggit.models.TagInput
import io.github.serpro69.kfaker.Faker
import org.apache.commons.math3.random.RandomDataGenerator
import org.junit.jupiter.api.Tags
import java.time.LocalDateTime
import java.util.*

val faker = Faker()
val randomNumberGenerator = RandomDataGenerator()

fun generateMockUserEntity() =
    TaggitUserEntity(
        id = UUID.randomUUID(),
        userName = faker.name.name(),
        email = faker.theITCrowd.emails(),
        avatarUrl = "http://google.com",
        githubUserName = faker.name.neutralFirstName(),
        githubUserId = randomNumberGenerator.nextLong(Long.MIN_VALUE, Long.MAX_VALUE),
        githubToken = "random_token",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now(),
    )

fun generateMockRepoEntity(userId: UUID? = null,
                           metadata: Metadata? = null) =
    TaggitRepoEntity(
        id = UUID.randomUUID(),
        userId = userId ?: UUID.randomUUID(),
        repoId = randomNumberGenerator.nextLong(Long.MIN_VALUE, Long.MAX_VALUE),
        repoName = faker.siliconValley.inventions(),
        githubLink = "http://google.com",
        githubDescription = null,
        starCount = randomNumberGenerator.nextInt(Int.MIN_VALUE, Int.MAX_VALUE),
        ownerAvatarUrl = "http://google.com",
        metadata = metadata
    )

fun generateRandomTagInput(tag: String? = null) = TagInput(tag ?: faker.book.title())

