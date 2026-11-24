let retry = 0;

do {
    console.log("Executing the code....");
    console.log("Retrying.....",retry);
    retry++;
} while (retry < 3);


// Nested the For Loop
// 1 Array - W

for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
        console.log(i, j);
    }
}

