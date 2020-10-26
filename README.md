# Chat Technical Challenge

### Start application

Prerequisites: docker and docker-compose

```javascript
bash start.sh
```

Backend and frontend docker containers will be built. To access application go to `http://localhost` in browser

### Technologies applied

- Backend: Spring Boot, JPA, Web Sockets
- Frontend: Angular

### Why these technologies

**Backend**: Spring Boot is enterprise ready framework, which works reasonably fast and in the same time permits quick development. Slow at startup, but works reliable and with best security practises in mind.

For quick development I used in-memory database and hided data access layer under a repository. In prod, world-scale scenario I would go with multi-layer approach, were first N messages would be stored in simple, but efficient database which gives possibility to query last N entries. For functionalities like full text search or sophisticated queries can be used databases which provide full power of indexes (if from open source: Postgre SQL for example)

**Frontend**: Angular was chosen for Frontend development. I like it's dependency injection out of the box paradigm usage and clean modularity.

Web Sockets were chosen to automatically sync messages in all user-sessions.

### Major todo tasks

1. Persistent database for backend
2. Pagination API of messages
3. Message validation (value of fields, length of content and etc) and giving feedback to user
4. Deduplication and periodic sync of messages in the front-end
5. Tests (unit and integration) both for back and front
6. Logs printing and collecting
7. Tracing of calls
