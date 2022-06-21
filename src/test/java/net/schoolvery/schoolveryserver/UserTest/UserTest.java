package net.schoolvery.schoolveryserver.UserTest;

import net.schoolvery.schoolveryserver.SpringTestSupport;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("User 단위 테스트")
public class UserTest extends SpringTestSupport {


    @DisplayName("User Create Test")
    @Test
    void 유저생성_확인() throws Exception {
        String user = mapper.writeValueAsString(new User(6,"김의빈", "Joe", 0104234, 1244,
                "성결대", "asdads","adsadsasd"));


        mockMvc.perform(
                post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(user)
                )
                .andExpect(status().isOk())
                .andDo(
                        restDocs.document(
                                responseFields(
                                        fieldWithPath("isSuccess").description("isSuccess"),
                                        fieldWithPath("code").description("code"),
                                        fieldWithPath("message").description("message"),
                                        subsectionWithPath("result").description("result")
                                )
                        )
                );
    }

    @DisplayName("Read User")
    @Test
    public void 유저_읽기() throws Exception {
        mockMvc.perform(
                get("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(
                        restDocs.document(
                                responseFields(
                                        fieldWithPath("isSuccess").description("isSuccess"),
                                        fieldWithPath("code").description("code"),
                                        fieldWithPath("message").description("message"),
                                        subsectionWithPath("result").description("result")
                                )
                        )
                );
    }

}
