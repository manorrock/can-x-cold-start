package main

import (
    "fmt"
    "net/http"
    "time"
)

type HttpHandler struct{}

func (h HttpHandler) ServeHTTP(res http.ResponseWriter, req *http.Request) {
    data := []byte("Hello World!")
    res.Write(data)
}

func main() {
    time1 := time.Now()
    fmt.Printf("TIME1: %d\n", time1.UnixMilli())
    handler := HttpHandler{}
    time2 := time.Now()
    fmt.Printf("TIME2: %d\n", time2.UnixMilli())
    http.ListenAndServe(":8080", handler)
}
