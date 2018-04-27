CREATE TABLE poll (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(255)
);

CREATE TABLE answer (
  id BIGSERIAL PRIMARY KEY,
  text VARCHAR(255),
  poll_id BIGINT REFERENCES poll(id),
  votes_count INTEGER
);