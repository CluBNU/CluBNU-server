# CluBNU-server
충북대학교 중앙동아리 관리 플랫폼 - 서버
# Getting Started
## Prerequisites
`clubnu-external-api/src/main/resources/application-local.yml`

- {KAKAO_CLIENT_ID} : 카카오 로그인 API를 사용하기 위한 클라이언트 ID
- {NAVER_CLIENT_ID} : 네이버 로그인 API를 사용하기 위한 클라이언트 ID
- {NAVER_CLIENT_SECRET} : 네이버 로그인 API를 사용하기 위한 클라이언트 Secret
- {JWT_SECRET} : JWT 토큰을 암호화하기 위한 Secret Key

## Build
- scripts/env-start.sh
  - 로컬에서 실행하기 위한 인프라 스트럭쳐 docker를 통한 구축
- scripts/env-stop.sh
  - 인프라 스트럭쳐 종료
- scripts/run.sh
  - 서버 실행
- scripts/stop.sh
  - 서버 종료
### Process
1. scripts/env-start.sh
2. scripts/run.sh
3. http://localhost:8082/swagger-ui/index.html
4. scripts/stop.sh
5. scripts/env-stop.sh