const form = document.getElementById("fanForm");

const previewName = document.getElementById("previewName");
const previewId = document.getElementById("previewId");

const paymentSection = document.getElementById("payment");
const registerSection = document.getElementById("register");

const bitcoinPanel = document.getElementById("bitcoinPanel");
const cardPanel = document.getElementById("cardPanel");

const finalId = document.getElementById("finalId");

const nicknameInput = document.getElementById("nickname");


nicknameInput.addEventListener("input", function () {

    previewName.textContent =
        this.value.trim() || "Your Nickname";

});


form.addEventListener("submit", async function (event) {

    event.preventDefault();

    const gameCheckboxes =
        document.querySelectorAll('input[name="game"]:checked');

    const registration = {
        fullName: document.getElementById("fullName").value,
        email: document.getElementById("email").value,
        country: document.getElementById("country").value,
        city: document.getElementById("city").value,
        social: document.getElementById("social").value,
        moment: document.getElementById("moment").value,
        fanYears: document.querySelector('input[name="fanYears"]:checked')?.value || "",
        game: Array.from(gameCheckboxes).map(function (box) {
            return box.value;
        }),
        message: document.getElementById("message").value,
        want: document.getElementById("want").value,
        nickname: nicknameInput.value,
        journey: document.getElementById("journey").value
    };

    let id;

    try {
        const response = await fetch("/api/fan-id/register", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(registration)
        });

        const savedRegistration = await response.json();

        id = savedRegistration.fanId;
    } catch (error) {
        console.error("Registration failed:", error);
        id = "CC-2026-0000";
    }

    previewId.textContent = id;

    paymentSection.classList.remove("hidden");

    registerSection.classList.add("hidden");

    paymentSection.scrollIntoView({
        behavior: "smooth"
    });

    window.generatedFanId = id;

});


function showPayment(method) {

    bitcoinPanel.classList.add("hidden");
    cardPanel.classList.add("hidden");

    if (method === "bitcoin") {
        bitcoinPanel.classList.remove("hidden");
    }

    if (method === "card") {
        cardPanel.classList.remove("hidden");
    }

}


function demoPayment() {

    const id =
        window.generatedFanId || "CC-2026-0000";

    finalId.textContent = id;

    paymentSection.classList.add("hidden");

    document.getElementById("success")
        .classList.remove("hidden");

    document.getElementById("success")
        .scrollIntoView({
            behavior: "smooth"
        });

}
