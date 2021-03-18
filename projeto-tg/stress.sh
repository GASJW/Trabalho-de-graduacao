#!/bin/bash
for i in {1..100000}; do
  curl localhost:30000/status
  # curl localhost:30001/status
  curl localhost:30000/status
  # curl localhost:30001/status
  sleep 0.001
done
